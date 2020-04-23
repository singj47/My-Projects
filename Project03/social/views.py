from django.http import HttpResponse,HttpResponseNotFound
from django.shortcuts import render,redirect,get_object_or_404
from django.contrib.auth.forms import AuthenticationForm, UserCreationForm, PasswordChangeForm
from django.contrib.auth import authenticate, login, logout, update_session_auth_hash
from django.contrib import messages

from . import models

def messages_view(request):
    """Private Page Only an Auqthorized User Can View, renders messages page
       Displays all posts and friends, also allows user to make new posts and like posts
    Parameters
    ---------
      request: (HttpRequest) - should contain an authorized user
    Returns
    --------
      out: (HttpResponse) - if user is authenticated, will render private.djhtml
    """
    count=request.session.get('count',1)
    if request.user.is_authenticated:
        user_info = models.UserInfo.objects.get(user=request.user)
        request.session['count']=count+1
        posts = list(models.Post.objects.order_by('-timestamp')[:count])
        # TODO Objective 10: check if user has like post, attach as a new attribute to each post
        for post in posts:
            like_check=models.Post.objects.filter(likes=user_info,id=post.id).count()
            if like_check>0:
                post.liked=True
            else:
                post.liked=False

        context = { 'user_info' : user_info
                  , 'posts' : posts 
                  }
        return render(request,'messages.djhtml',context)

    request.session['failed'] = True
    return redirect('login:login_view')

def account_view(request):
    """Private Page Only an Authorized User Can View, allows user to update
       their account information (i.e UserInfo fields), including changing
       their password
    Parameters
    ---------
      request: (HttpRequest) should be either a GET or POST
    Returns
    --------
      out: (HttpResponse)
                 GET - if user is authenticated, will render account.djhtml
                 POST - handle form submissions for changing password, or User Info
                        (if handled in this view)
    """
    if request.user.is_authenticated:
        if request.method == "POST":
            p_form=PasswordChangeForm(request.user,request.POST)
            info_form=models.UserInfoForm(request.POST,request.user)
            if p_form.is_valid():
                user=p_form.save()
                update_session_auth_hash(request, user)
            if info_form.is_valid():
                user_info=models.UserInfo.objects.get(user=request.user)
                user_info.employment=request.POST['employment']
                user_info.location=request.POST['location']
                user_info.birthday=request.POST['birthday']
                new_interest=info_form.cleaned_data.get('add_interest')
                
                if not new_interest == '':
                    models.Interest.objects.create(label=new_interest)
                    user_info.interests.add(new_interest)
                
                interest=request.POST.get('interests')
                if  not  interest== '':
                        user_info.interests.add(interest)
                user_info.save()
                return redirect('social:messages_view')
            else:
                failed=True
        else:
            failed=request.session.get('fail',False)
        p_form = PasswordChangeForm(request.user)
        user_info = models.UserInfo.objects.get(user=request.user)
        info_form=models.UserInfoForm(instance=user_info)
            
        context = { 'user_info' : user_info,
                    'form' : p_form,
                    'info_form': info_form, 
                    'fail': failed}
        return render(request,'account.djhtml',context)

    request.session['failed'] = True
    return redirect('login:login_view')

def people_view(request):
    """Private Page Only an Authorized User Can View, renders people page
       Displays all users who are not friends of the current user and friend requests
    Parameters
    ---------
      request: (HttpRequest) - should contain an authorized user
    Returns
    --------
      out: (HttpResponse) - if user is authenticated, will render people.djhtml
    """
    size=request.session.get('size',1)
    if request.user.is_authenticated:
        user_info = models.UserInfo.objects.get(user=request.user)
        # TODO Objective 4: create a list of all users who aren't friends to the current user (and limit size)
        request.session['size']=size+1
        all_people=list(models.UserInfo.objects.exclude(friends=user_info).exclude(user=request.user)[:size])
        for people in all_people:
            sent_check=models.FriendRequest.objects.filter(from_user=user_info,to_user=people).count()
            if sent_check>0:
                people.sent=True
            else:
                people.sent=False
        # TODO Objective 5: create a list of all friend requests to current user
        friend_requests = list(models.FriendRequest.objects.filter(to_user=user_info))

        context = { 'user_info' : user_info,
                    'all_people' : all_people,
                    'friend_requests' : friend_requests }

        return render(request,'people.djhtml',context)

    request.session['failed'] = True
    return redirect('login:login_view')

def like_view(request):
    postID = request.POST.get('post_id')
    if postID is not None:
        if request.user.is_authenticated:
                user=models.UserInfo.objects.get(user=request.user)
                post_liked=models.Post.objects.get(id=postID)
                post_liked.likes.add(user)
                return HttpResponse()
               
        else:
            return redirect('login:login_view')

    return HttpResponseNotFound('like_view called without postID in POST')

def post_submit_view(request):
    '''Handles POST Request recieved from submitting a post in messages.djhtml by adding an entry
       to the Post Model
    Parameters
	----------
	  request : (HttpRequest) - should contain json data with attribute postContent, a string of content

	Returns
	-------
   	  out : (HttpResponse) - after adding a new entry to the POST model, returns an empty HttpResponse,
                             or 404 if any error occurs
    '''
    postContent = request.POST.get('post_content')
    if postContent is not None:
        if request.user.is_authenticated:
            # TODO Objective 8: Add a new entry to the Post model
            user=models.UserInfo.objects.get(user=request.user)
            newpost=models.Post()
            newpost.owner=user
            newpost.content=postContent
            newpost.save()
            status='success'
            return HttpResponse(status)
        else:
            return redirect('login:login_view')

    return HttpResponseNotFound('post_submit_view called without postContent in POST')

def more_post_view(request):
    '''Handles POST Request requesting to increase the amount of Post's displayed in messages.djhtml
    Parameters
	----------
	  request : (HttpRequest) - should be an empty POST

	Returns
	-------
   	  out : (HttpResponse) - should return an empty HttpResponse after updating hte num_posts sessions variable
    '''
    if request.user.is_authenticated:
        # update the # of posts dispalyed

        # TODO Objective 9: update how many posts are displayed/returned by messages_view

        # return status='success'
        return HttpResponse()

    return redirect('login:login_view')

def more_ppl_view(request):
    '''Handles POST Request requesting to increase the amount of People displayed in people.djhtml
    Parameters
	----------
	  request : (HttpRequest) - should be an empty POST

	Returns
	-------
   	  out : (HttpResponse) - should return an empty HttpResponse after updating the num ppl sessions variable
    '''
    if request.user.is_authenticated:
        # update the # of people dispalyed

        # TODO Objective 4: increment session variable for keeping track of num ppl displayed

        # return status='success'
        return HttpResponse()

    return redirect('login:login_view')

def friend_request_view(request):
  
    uid = request.POST.get('frID')
    if uid is not None:
        if request.user.is_authenticated:
            frequest= models.FriendRequest()
            frequest.to_user=models.UserInfo.objects.get(user=uid)
            frequest.from_user=models.UserInfo.objects.get(user=request.user)
            frequest.save()
            status='success'

            return HttpResponse(status)
        else:
            return redirect('login:login_view')

    return HttpResponseNotFound('friend_request_view called without frID in POST')

def accept_decline_view(request):
    '''Handles POST Request recieved from accepting or declining a friend request in people.djhtml,
       sent by people.js, deletes corresponding FriendRequest entry and adds to users friends relation
       if accepted
    Parameters
	----------
	  request : (HttpRequest) - should contain json data with attribute decision,
                                a string of format A-name or D-name where name is
                                a valid username (the user who sent the request)

	Returns
	-------
   	  out : (HttpResponse) - deletes entry to FriendRequest table, appends friends in UserInfo Models,
                             then returns an empty HttpResponse, 404 if POST data doesn't contain decision
    '''
    sent_from = request.POST.get('sent_from')
    decision=request.POST.get('decision')
    if decision is not None:
        # TODO Objective 6: parse decision from data
        if request.user.is_authenticated:
            user=models.UserInfo.objects.get(user=request.user)
            if decision == 'Accepted':
                user.friends.add(sent_from)
            frequest=models.FriendRequest.objects.filter(from_user=sent_from,to_user=user).delete()
            # TODO Objective 6: delete FriendRequest entry and update friends in both Users

            # return status='success'
            status='success'
            return HttpResponse(status)
        else:
            return redirect('login:login_view')

    return HttpResponseNotFound('accept-decline-view called without decision in POST')


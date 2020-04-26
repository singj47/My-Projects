#  CS 1XA3 Project03 - singj47
## Usage
   Install conda enivornment with

```pip install django```


   Run locally with

```python manage.py runserver localhost:8000```

   Run on mac1xa3.ca with

```python manage.py runserver localhost:10095```

Log in with TestUser, password 1234

## Objective 01

 ### Description:

- this feature is displayed in signup.djhtml which is rendered by
signup_view
- it allows the user to create a new account once directed to the signup page.

 ### Exception:

- If the passwords don't match it throws an error .
- Even if one of the conditions turn out to be False while creating
a new account , it shows an error.
- While on the login and signup page clicking on the top right icon on the Navbar
will keep on reloading the page .

## Objective 02

 ### Description:

- this feature is displayed in social_base.djhtml
- it displays the currently logged in user and the user info which includes
employment, location , birthday and user interests.

## Objective 03

 ### Description:

- this feature is displayed in account.djhtml which is rendered by
account_view
- it allows the user to update user info and change the current password
by clicking the top right icon on the Navbar .
- Template account.djhtml has been edited to Handle POST requests sent by
the form’s to update the UserInfo object accordingly.

 ### Exception:

- while updating interests a user cannot add the same interest as any other user
if the user feels like adding the same interest as any other user he may add
it via the list of interest given .
- form would not update if birthday box is left empty.
- form will not update if birthday does not follow the format of (YYYY-MM-DD).
- form would not accept a value more than 30 characters in employment.
- form would not accept a value more than 50 characters in location.
- form would not accept a value more than 30 characters in interest.

## Objective 04

 ### Description:

- this feature is displayed in people.djhtml which is rendered by
people_view
- it makes a POST Request from people.js to /e/singj47/social/messages/
which is handled by more_ppl_view
- it shows the user the number of people who are not friends of the user
and by clicking on the more button the user could see more people .

 ### Exception:

- if there is only one user using the system or every other user
is a friend of that one user more button will just reload the
page without showing anything else.

## Objective 05

 ### Description:

- this feature is displayed in people.djhtml which is rendered by
people_view
- All Friend Request buttons are linked to a JQuery event in people.js ,which
uses its id to send a POST request to the function  friend_request_view
- it allows the current user to send friend requests to different users by
clicking on the ' Friend Request' button , once request has been sent the button disables
automatically.

### Exception:

- once friend request is sent by clicking on the friend request button
there isn't a way to cancel that friend request unless the user declines the request.

## Objective 06

 ### Description:

- this feature is displayed in people.djhtml which is rendered by
 accept_decline_view
- it makes a POST Request from people.js which enables the user to actually know
the username of the user who sent the request and accept or decline accordingly.
- if accepted it shows the accepted user under the friends column for both the users.

## Objective 07

 ### Description:

- this feature is displayed in messages.djhtml which is rendered by
messages_view
- this feature displays all the friends of the currently logged in user

## Objective 08

 ### Description:

- respective editing has been done in Project03/social/static/messages.js
to enable this feature.
- the feature allows the user to post by clicking on the post button , if the user
wants status can be added to the post.
- once post is successfully posted the page is reloaded.
- form would not accept a value more than 280 characters in the status column.

### Exception:

- form would not accept a value more than 280 characters in the status column.

## Objective 09

 ### Description:

- this feature is displayed in messages.djhtml which is rendered by
 messages_view
- it enables the user to click on the more button to see all the posts posted
 by other users .
- the posts displayed are in newest to oldest order irrespective of who posted it.
- After the user logs out the page is reset again.

### Exception:

-if there is no post posted by any user more button will just reload the current
page when clicked .

## Objective 10

 ### Description:

- this feature is displayed in messages.djhtml which is rendered by
messages_view
- this feature enables user to like the posts posted by different users
and also displays the like count beside it.
 - after the user has liked a particular post the like button gets disabled,
 means the user will no longer be able to like the same post .

## Objective 11

### Description:

 - this objective shows a variety of test users, shows many posts and likes and
 different friend requests to showcase all the functionality user has implemented.

 - Following are the various users and their passwords used to populate the database:

- 
   Usernames | Passwords
   --------- | ----------
   TestUser  | 1234
   Friend1     | Password@1
   Friend2     | Password@2
   Friend3     | Password@3
   Friend4     | Password@4
   Friend5     | Password@5
   Friend6     | Password@6
   Friend7     | Password@7
   
- a new user can also be created easily by following objective 1.







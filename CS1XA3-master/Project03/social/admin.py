from django.contrib import admin
from .models import Interest,UserInfo,FriendRequest,Post
# Register your models here.
admin.site.register(Interest)
admin.site.register(UserInfo)
admin.site.register(FriendRequest)
admin.site.register(Post)

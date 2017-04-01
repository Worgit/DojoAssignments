from __future__ import unicode_literals

from django.db import models
from ..loginApp.models import User
# Create your models here.

class Post(models.Model):
	text = models.TextField(max_length=255)
	likes = models.ManyToManyField(User, related_name = "likes")
	poster = models.ForeignKey(User, related_name = "posts")
	created_at = models.DateTimeField(auto_now_add = True)
	updated_at = models.DateTimeField(auto_now = True)
from __future__ import unicode_literals

from django.db import models
from ..loginApp.models import User
# Create your models here.


class Author(models.Model):
	name = models.TextField(max_length=255)
	created_at = models.DateTimeField(auto_now_add = True)
	updated_at = models.DateTimeField(auto_now = True)

class Book(models.Model):
	name = models.TextField(max_length=255)
	author = models.ForeignKey(Author, related_name = "books")
	reviews = models.ManyToManyField(User, through = "Review", related_name = "reviews")
	created_at = models.DateTimeField(auto_now_add = True)
	updated_at = models.DateTimeField(auto_now = True)

class Review(models.Model):
	rating = models.PositiveSmallIntegerField()
	text = models.TextField(max_length=255)
	poster = models.ForeignKey(User, on_delete=models.CASCADE)
	book = models.ForeignKey(Book, on_delete=models.CASCADE)
	created_at = models.DateTimeField(auto_now_add = True)
	updated_at = models.DateTimeField(auto_now = True)
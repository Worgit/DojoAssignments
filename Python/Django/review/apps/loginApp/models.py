from __future__ import unicode_literals

from django.db import models

import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

# Create your models here.
class UserManager(models.Manager):
	def validation(self,name, alias, email, password, confirm):
		retlist = []
		##print "*"*80
		if len(name) < 2:
			##print "*"*40
			retlist.append("First Name Too Short.")
		if len(alias) < 2:
			##print "*"*35
			retlist.append("Last Name Too Short.")
		if len(email) < 1:
			##print "*"*30
			retlist.append("Email Too Short.")
		elif not EMAIL_REGEX.match(email):
			##print "*"*25
			retlist.append("Invalid Email.")
		if len(password) < 8:
			##print "*"*20
			retlist.append("Password Too Short.")
		if password != confirm:
			##print "*"*15
			retlist.append("Password does not match confirmation.")
		if len(retlist) == 0:
			return "Success"
		return retlist

class User(models.Model):
	name = models.CharField(max_length=255)
	alias = models.CharField(max_length=255)
	email = models.CharField(max_length=255)
	password = models.CharField(max_length=255)
	created_at = models.DateTimeField(auto_now_add = True)
	updated_at = models.DateTimeField(auto_now = True)
	objects = UserManager()

from django.shortcuts import render, redirect
from django.core.urlresolvers import reverse
from django.core.exceptions import ObjectDoesNotExist, MultipleObjectsReturned
from .models import Post
from ..loginApp.models import User
from django.db.models import Count
# Create your views here.

def index(request):
	posts = Post.objects.annotate(num_likes = Count('likes')).order_by('-created_at')[:5]
	message = ""
	user = User.objects.get(id = request.session['id'])
	##print "*"*80
	##print request.session['id']
	for userpost in posts:
		##print Post.objects.get(likes = user)
		message += "<p>{} {} {} likes</p>".format(userpost.text, userpost.created_at, userpost.num_likes)
		if userpost.poster.id == request.session['id']:
			message +="<p>You posted this</p><a href = '{}'>Delete</a>".format(reverse('secrets:delete', kwargs={'id': userpost.id}))
		##elif Post.objects.get(likes = user):
			##if userpost.likes.get(id=request.session['id']).id == request.session['id']:
				##message += "<p>You liked this</p>"
		else:
			try:
				newpost = User.objects.get(likes = userpost)
			except ObjectDoesNotExist:
				message += "<a href = '{}'>Like</a>".format(reverse('secrets:like', kwargs={'id': userpost.id}))
				continue
			except MultipleObjectsReturned:
				##print "*"*80
				##print "multiple"
				continue
			"""new = Post.objects.get(likes = user)
			newpost = User.objects.get(likes = userpost)
			print new.id
			print newpost.id
			print user.id
			if new == user:"""
			message += "<p>You liked this</p>"
	context = {
		"message": message
	}
	return render(request, "secrets/secrets.html", context)
	"""print "*"*80
	print reverse('secrets:delete', kwargs={'id': post.id})"""

def delete(request, id):
	Post.objects.get(id=id).delete()
	return redirect (reverse('secrets:index'))

def postnew(request):
	text = request.POST["text"]
	poster = User.objects.get(id = request.session['id'])
	Post.objects.create(text=text, poster = poster)
	return redirect(reverse('secrets:index'))
	
def popular(request):
	posts = Post.objects.annotate(num_likes = Count('likes')).order_by('-num_likes')
	message = ""
	for userpost in posts:
		##print Post.objects.get(likes = user)
		message += "<p>{} {} {} likes</p>".format(userpost.text, userpost.created_at, userpost.num_likes)
		if userpost.poster.id == request.session['id']:
			message +="<p>You posted this</p><a href = '{}'>Delete</a>".format(reverse('secrets:delete', kwargs={'id': userpost.id}))
		##elif Post.objects.get(likes = user):
			##if userpost.likes.get(id=request.session['id']).id == request.session['id']:
				##message += "<p>You liked this</p>"
		else:
			try:
				newpost = User.objects.get(likes = userpost)
			except ObjectDoesNotExist:
				message += "<a href = '{}'>Like</a>".format(reverse('secrets:like', kwargs={'id': userpost.id}))
				continue
			except MultipleObjectsReturned:
				##print "*"*80
				##print "multiple"
				continue
			"""new = Post.objects.get(likes = user)
			newpost = User.objects.get(likes = userpost)
			print new.id
			print newpost.id
			print user.id
			if new == user:"""
			message += "<p>You liked this</p>"
	context = {
		"message": message
	}
	return render(request, "secrets/popular.html", context)

def like(request, id):
	userpost = Post.objects.get(id=id)
	user = User.objects.get(id=request.session['id'])
	userpost.likes.add(user)
	userpost.save()
	return redirect(reverse('secrets:index'))

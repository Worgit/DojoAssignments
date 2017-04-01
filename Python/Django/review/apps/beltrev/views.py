from django.shortcuts import render, redirect
from django.core.urlresolvers import reverse
from django.core.exceptions import ObjectDoesNotExist, MultipleObjectsReturned
from ..loginApp.models import User
from models import Author, Review, Book
from django.db.models import Count
# Create your views here.

def index(request):
	books = Book.objects.all()
	reviews = Review.objects.all().order_by('-created_at')[:3]
	others = Book.objects.exclude(reviews = None)
	print books
	print others
	user = User.objects.get(id = request.session['id'])
	context = {
		"books": books,
		"reviews": reviews,
		"others": others,
		"user": user
	}
	return render(request, "beltrev/index.html", context)
	"""print "*"*80
	print reverse('secrets:delete', kwargs={'id': post.id})"""

def delete(request, id):
	Review.objects.get(id=id).delete()
	return redirect (reverse('beltrev:index'))

def add(request):
	if request.method == "POST":
		title = request.POST["title"]
		author = request.POST["author"]
		if len(request.POST['input']) > 0:
			author = request.POST['input']
		text = request.POST["review"]
		rating = request.POST["rating"]
		user = User.objects.get(id = request.session['id'])
		try:
			newauthor = Author.objects.get(name = author)
		except ObjectDoesNotExist:
			Author.objects.create(name = author)
			newauthor = Author.objects.get(name = author)
		Book.objects.create(name=title, author = newauthor)
		newbook = Book.objects.get(name = title)
		Review.objects.create(rating = rating, text = text, poster = user, book = newbook)
		return redirect(reverse('beltrev:book', kwargs = {'id': newbook.id}))
	context = {
		"authors": Author.objects.all()
	}
	return render(request, "beltrev/add.html", context)
	
def book(request, id):
	books = Book.objects.all()
	book = Book.objects.get(id = id)
	author = book.author
	authors = Author.objects.all()
	reviews = Review.objects.filter(book = book).order_by('-created_at')
	context = {
		"books": books,
		"reviews": reviews,
		"book": book,
		"author": author,
		"authors": authors
	}
	return render(request, "beltrev/book.html", context)
	"""print "*"*80
	print reverse('secrets:delete', kwargs={'id': post.id})"""

def review(request, id):
	book = Book.objects.get(id = id)
	user = User.objects.get(id=request.session['id'])
	text = request.POST["review"]
	rating = request.POST["rating"]
	author = ""
	Review.objects.create(rating = rating, text = text, poster = user, book = book)
	return redirect(reverse('beltrev:book', kwargs = {'id': id}))

def users(request, id):
	user = User.objects.annotate(num_reviews = Count('reviews')).get(id = id)
	books = Book.objects.filter(reviews__id = id).distinct()
	print books
	for book in books:
		print book.name
	reviews = Review.objects.filter(poster = user)
	context = {
	"books": books,
	"reviews": reviews,
	"user": user
	}
	return render(request, "beltrev/user.html", context)

def logout(request):
	del request.session['name']
	del request.session['id']
	return redirect(reverse('login:index'))
	
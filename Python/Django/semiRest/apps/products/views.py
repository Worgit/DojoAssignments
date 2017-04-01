from django.shortcuts import render, redirect
from .models import Product
# Create your views here.

	
def delete(request, id):
	Product.objects.get(id=id).delete()
	return redirect ('/products')

def create(request):
	if request.method == "POST":
		name = request.POST["name"]
		desc = request.POST["description"]
		price = request.POST["price"]
		Product.objects.create(name=name,description=desc, price = price)
	context = {
		"products": Product.objects.all(),
	}
	return render(request, "products/index.html", context)

def show(request, id):
	product = Product.objects.get(id=id)
	if request.method == "GET":
		context = {
		"product": product,
		}
		return render(request, "products/show.html", context)
	name = request.POST["name"]
	desc = request.POST["description"]
	price = request.POST["price"]
	product.name = name
	product.description = desc
	product.price = price
	product.save()
	return redirect('/products')

def new(request):
	return render(request, "products/add.html")

def edit(request, id):
	context = {
		"product": Product.objects.get(id=id),
		}
	return render(request, "products/edit.html", context)
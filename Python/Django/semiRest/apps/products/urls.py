from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^products$', views.create, name = 'index'),
    url(r'^products/(?P<id>\d+)/destroy', views.delete, name = 'delete'),
    url(r'^products/new', views.new, name = 'new'),
    url(r'^products/(?P<id>\d+)$', views.show, name = 'show'),
    url(r'^products/(?P<id>\d+)/edit', views.edit, name = 'edit')
]
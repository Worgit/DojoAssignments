from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index, name = 'index'),
    url(r'^remove/(?P<id>\d+)$', views.remove, name = 'remove'),
    url(r'^delete/(?P<id>\d+)$', views.delete, name = 'delete'),
    url(r'^back', views.back, name = 'back'),
    url(r'^add', views.add, name = 'add'),
    url(r'^users_courses', views.courses, name = 'courses'),
    url(r'^newuser', views.adduser, name = 'adduser')
]
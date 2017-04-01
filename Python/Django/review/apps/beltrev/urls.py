from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index, name = 'index'),
    url(r'^add', views.add, name = 'add'),
    url(r'^(?P<id>\d+)$', views.book, name = 'book'),
    url(r'^user/(?P<id>\d+)', views.users, name = 'user'),
    url(r'^(?P<id>\d+)/review', views.review, name = 'review'),
    url(r'^(?P<id>\d+)/delete', views.delete, name = 'delete'),
    url(r'^logout', views.logout, name = 'logout'),
]
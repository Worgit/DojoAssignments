from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index, name = 'index'),
    url(r'^postnew', views.postnew, name = 'postnew'),
    url(r'^(?P<id>\d+)/like', views.like, name = 'like'),
    url(r'^popular', views.popular, name = 'popular'),
    url(r'^(?P<id>\d+)/delete', views.delete, name = 'delete')
]
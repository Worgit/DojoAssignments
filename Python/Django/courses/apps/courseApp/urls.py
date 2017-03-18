from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index, name = 'index'),
    url(r'^remove/(?P<id>\d+)$', views.remove),
    url(r'^delete/(?P<id>\d+)$', views.delete),
    url(r'^back', views.back),
    url(r'^add', views.add)
]
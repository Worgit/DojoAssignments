from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^ninjas$', views.showAll),
    url(r'^ninjas/(?P<color>\w+)$', views.show)]
    ##url(r'^(?p<color>\w+)/$', views.whatever, ]
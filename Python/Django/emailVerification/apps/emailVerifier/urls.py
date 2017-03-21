from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^check', views.checker),
    url(r'^success', views.success)
]
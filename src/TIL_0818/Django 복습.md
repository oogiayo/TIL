# Django

## 1. 복습

### 1.1 Project 시작하기

```python
# django 설치하기
pip install django==3.1

# project 만들기
django-admin startproject {project_name}

# server 가동하기
python manage.py runserver
```

- 서버 주소
  - `http://127.0.0.1:8000/` = `localhost:8000/`



### 1.2 Application 만들기

```python
python manage.py startapp {application_name}
```



### 1.3 DTL(Django Template Language)

- `django-mathfilters` 라이브러리 사용 시 많은 간편한 연산을 수행할 수 있다!

- datetime.now()   => type이 객체임!! String 아님..ㅋ





## 2. Template Inheritance

> Template(html 파일)의 기본 틀을 설정해서 여러 Application의 Template에 적용시킬 수 있다 => 상속!

```html
{% block content %}

{% endblock %}
이 부분만 자식에게 상속할 내용으로 설정

--------------------------------------

{% extends 'base.html' %}

상속받아 사용하려면 자식 Template의 첫 시작에 기입한다.
```

### 

## 3.  프로젝트의 urls를 Hurb로 사용하기

- `include`

```python
# pjt 디렉터리의 urls.py 파일
from django.urls import path, include

urlpatterns = [
    path('app/', include('app.urls')),
]

#-----------------------------------------
# app 디렉터리의 urls.py 파일
from django.urls import path
from . import views

urlpatterns = [
    path('', 'pages.html'),
]
```


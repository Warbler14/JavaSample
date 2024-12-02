# Python3 샘플 코드 #


import requests

url = 'http://apis.data.go.kr/B551505/whois/ipas_country_code'
params ={'serviceKey' : '서비스키', 'query' : '202.30.50.51', 'answer' : 'xml' }

response = requests.get(url, params=params)
print(response.content)
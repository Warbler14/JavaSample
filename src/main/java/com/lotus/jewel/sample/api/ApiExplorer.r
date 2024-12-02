/* R 4.1.0 샘플 코드 */

install.packages("httr") # HTTP통신을 위한 패키지 설치

library(httr)
GET('http://apis.data.go.kr/B551505/whois/ipas_country_code?serviceKey=서비스키&query=202.30.50.51&answer=xml')
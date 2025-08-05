/* Javascript 샘플 코드 */


var xhr = new XMLHttpRequest();
var url = 'http://apis.data.go.kr/B551505/whois/ipas_country_code'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'서비스키'; /*Service Key*/
queryParams += '&' + encodeURIComponent('query') + '=' + encodeURIComponent('202.30.50.51'); /**/
queryParams += '&' + encodeURIComponent('answer') + '=' + encodeURIComponent('xml'); /**/
xhr.open('GET', url + queryParams);
xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
        alert('Status: '+this.status+'nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+'nBody: '+this.responseText);
    }
};

xhr.send('');


/* cURL 샘플 코드 */


//curl --include --request GET
//'http://apis.data.go.kr/B551505/whois/ipas_country_code?serviceKey=서비스키&query=202.30.50.51&answer=xml'
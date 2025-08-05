/* NodeJs 12 샘플 코드 */


var request = require('request');

var url = 'http://apis.data.go.kr/B551505/whois/ipas_country_code';
var queryParams = '?' + encodeURIComponent('serviceKey') + '=서비스키'; /* Service Key*/
queryParams += '&' + encodeURIComponent('query') + '=' + encodeURIComponent('202.30.50.51'); /* */
queryParams += '&' + encodeURIComponent('answer') + '=' + encodeURIComponent('xml'); /* */

request({
    url: url + queryParams,
    method: 'GET'
}, function (error, response, body) {
    //console.log('Status', response.statusCode);
    //console.log('Headers', JSON.stringify(response.headers));
    //console.log('Reponse received', body);
});
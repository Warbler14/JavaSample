// C# 샘플 코드
using System;
using System.Net;
using System.Net.Http;
using System.IO;

namespace ConsoleApp1
{
    class Program
    {
        static HttpClient client = new HttpClient();
        static void Main(string[] args)
        {
            string url = "http://apis.data.go.kr/B551505/whois/ipas_country_code"; // URL
            url += "?ServiceKey=" + "서비스키"; // Service Key
            url += "&query=202.30.50.51";
            url += "&answer=xml";

            var request = (HttpWebRequest)WebRequest.Create(url);
             request.Method = "GET";

            string results = string.Empty;
            HttpWebResponse response;
            using (response = request.GetResponse() as HttpWebResponse)
            {
                StreamReader reader = new StreamReader(response.GetResponseStream());
                results = reader.ReadToEnd();
            }

            Console.WriteLine(results);
        }
    }
}
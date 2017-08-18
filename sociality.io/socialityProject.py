import bs4 as bs
import urllib.request

#Programi calistirdiktan sonra konsola 
#Hepsiburada.com adresinden istediginiz urunun linkini kopyalayiniz
#kopyaladiktan sonra enter a basiniz urunun fiyat bilgisi gelecektir.



adres = input("Linki giriniz: ")

url = urllib.request.urlopen(adres).read()

soup = bs.BeautifulSoup(url,'lxml')

fiyatAlani1 = soup.find("span", attrs={"data-bind":"markupText:'currentPriceBeforePoint'"})
fiyatAlani2 = soup.find("span", attrs={"data-bind":"markupText:'currentPriceAfterPoint'"})
paraBirimi = soup.find("span", attrs={"class":"turkishLira"})
price1 = fiyatAlani1.text
price2 = fiyatAlani2.text
currencyType = paraBirimi.text
print(price1 + "," + price2, currencyType)

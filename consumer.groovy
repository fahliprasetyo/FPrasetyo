import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

def response = WS.sendRequest(findTestObject('API/Get-User'))

WS.verifyResponseStatusCode(response, 200)
WS.verifyElementPropertyValue(response, 'data.id', 2)

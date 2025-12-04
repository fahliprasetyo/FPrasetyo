import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

def request = findTestObject('API/Post-CreateUser')
def response = WS.sendRequest(request)

WS.verifyResponseStatusCode(response, 201)
WS.verifyElementPropertyValue(response, 'name', 'John Doe')

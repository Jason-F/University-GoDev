University-GoDev
================
Software Engineering and Design 4 (assignment)

Creating a system that involves a centralised database sending out instructions to terminals based on nearest proximity
The database will store gps location of the user requesting for a pick up. This information will be populated to all taxi drivers in the nearest proximity of the user.
Once one taxi driver has accepted the request, the request will be deactivated from other driver and a countdown time will be activated on the user's device based on the estimated time computed from GoogleMap api, that will take to the driver to reach his location.


Functioninality:
  
- Service functions through a mobile application
- Application is connected to the database
- App must be installed on both customer and drivers mobile device
- Driver will have a modified version of the app(only the drivers can have this ap installed)
- When customer makes a request for a taxi, the database stores the users request along with their GPS location
- The request will then be sent to all the taxi drivers within a specified proximity of the users location.
- Taxi operates who already have a customer or have accepted a request will not be notified
- The first taxi driver to successfully accept the request will recieve the taxi request along with the co-ordinates of the customer.
- When the user has made a request they will have a 10min countdown timer, during which they cannot make additional requests
- There will be an option to cancel the request but upon doing so the user cannot make another request for 10min
- The driver can also cancel the request should there be an emergency(vehicle collision), the request will then be resent out, with the user being re-notified
- The user will then recieve a pre-generated message informing them whether the request was successful or not
- If successful, the user will have a GUI depicting a car traveling to a person, with a meter/bar depicting the duration. A timer will be included as well


Requirements:
-

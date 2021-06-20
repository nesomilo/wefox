# SCENARIO 1: "Booking Options" from single product (hotel)

## Short description

* Smaller form "Booking Options"
* On the right side of a single product (hotel)
* It's the first step in a booking process flow
* Contains only a basic fields:
	* Date
	* "Change date" button
	* Number of adults with calculated price (default value: 1)
	* Number of children with calculated price (default value: 0)
	* Total for payment (in US dollars)
	* Deposit (in US dollars)
	* "Book now" submit button

## Potential bugs and improvements

* Several different and "not matching" colors on the form
	* Just don't look nice
	* Maybe consider using different shades of compatible colors
	* Action that confirms booking should be in different color (ex. light green)
* "Booking date" field doesn't have a "legend"
	* The field is not explained, users could be confused
	* "Booking date" field should be "Booking dates" fields (date from-to)
	* Now users can select only a single date
	* System doesn't allow users to book a hotel for a couple of days
* Users can delete and input any value in "Booking date" field
	* Missing a validation that prevents going to the next step if correct date isn't entered (right format, future date)
* "Change date" action doesn't work as expected
	* Once triggered action should restart or clean the booking date
	* Now it just refreshes the page and the last entered date is still saved
* Prices and deposits are shown in US dollar currency only
	* Missing option to convert it into any frequently used currency (ex. euro)
* On the "Adults" and "Child" fields is shown calculated price for entered values, but it's not user friendly
	* Users could be confused how does it work
* Fields for entering number of guests (Adults/Children/infant) have predefined values
	* Users should be able to reserve staying for desired number of guests
	* Now they would need to create multiple bookings in order to reserve accommodation for several guests (if desired number is not an option in dropdown)
* "Child" field should be renamed into "Children"
* "infant" field is not shown on each form
* "infant" should start with capital letter so the form is consistent



# SCENARIO 2: Confirm booking (next step in booking flow)

## Short description

* More extensive form with more data to fill
* On the left side two tabs
	* "Book as a guest"
	* "Sign In"
* Different forms for signed in and incognito users
* Same fields for both forms
	* "Coupon Code"
	* "Guest Informations"
* On the right side preview of a booked accommodation: dates, price...

## Potential bugs and improvements
	
* "Booking Date" information is not correct
	* Not the one that is chosen on the previous step
* "Rental Days and Nights" information is not correct
	* Not the valid data that user entered on the previous step
* On the form it's not clear which fields are optional and which ones are required
* "Email required" validation message shown twice
* "Confirm" field should be "Confirm email"
* Email validation message should be adjusted to cover negative scenarios
	* Leaving email empty or when email and confirm email don't match
* All fieleds except: Name, Last Name and Email are optional
	* Important data like country or phone number are not mandatory fields
* No adequate validations on input fields
	* Length (range of characters that can be entered)
		* Ex. "First Name must contain between 2 and 50 characters."
	* Format (valid input)
		* Ex. "Phone number can't contain letters."
		* Ex. "Age should be between 0-100."
* Validation message would be better displayed under the highlighted problematic field
* "What is a promo code?" should be link to the short explanation, but it doesn't work
* "Guest Informations" should be "Guest Information" (spelling mistake)
* It shouldn't be possible to "copy-paste" password behind asterisk
* "Terms and conditions" should be moved somewhere aside
	* Now it's on two places
	* Different expressions used "Terms" and "Rules and Restrictions"
	* There should be a checkbox that confirms user read it



# SCENARIO 3: Invoice and paying method (last steps)

## Short description

* On the left side is section "Booking Details"
	* It should contain all information entered in previous step
* On the right side is a section "Summary"
	* It should contain price data (paycheck)
* On the top of the page is information about "booking status"
* Once created, unpaid paycheck limitation is 24 hours
	* Users should reserve or finish the payment in that time
* Two actions possible here
	* "Pay at arrival"
	* "Pay now"
* "Pay at arrival" changes booking status from "Unpaid" to "Reserved"
* On "Pay now" users need to select "Payment method" and proceed with the payment 

## Potential bugs and improvements

* Payment methods don't work as expected
	* System tries to load data but nothing happens (PayStack Credit Card)
	* Paying method isn't secure (JazzCash)
	* Paying method don't show "Pay now" action (Bank Transfer) 
* "Select payment method" is an item in the list
	* It should just be a dropdown legend
* Action "back" from invoice preview redirects users two steps back



# Other questions and write-up

* In specification no information about OS, browser...
	* I'll limit myself to Windows/GoogleChrome
* Some illogical details (text, pictures)
	* I'll not focus on this, it's dummy data probably
* Some functionalities close to booking
	* Again, I'll focus on booking functionality only, as it says in spec
* Writing test cases?
	* A lot of forms and fields, test cases could be written all day long
	* Considering the time I am supose to spend on this task, it's not an option to write it down
* During exploring noticed
	* A lot more test cases to cover
	* More bugs/improvements
	* Needed more time
* 3 key scenarios:
	* Booking option from single product (hotel)
	* Confirm booking (as a guest/as logged in user)
	* Invoice (details/pay on arrival/pay now)
* For this kind of software it's important to pay special attention on
	* UI - user friendly, well structured
	* Performance
		* Open site, should support high traffic
		* System shouldn't slow down or break
	* Security
		* The single most important attribute here
		* Bank and other personal data should be highly secured
	* Portability
		* Open site, different kind of users
		* Everything should work cross-platform
		* Operating Systems, devices, browsers, resolutions...



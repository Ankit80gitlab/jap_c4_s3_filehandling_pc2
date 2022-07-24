## Practice Statement - Sales Analyzer

**Sales analysis is done at regular intervals by sales managers of large organizations. 
Studying and analyzing past sales records, helps these sales managers to decide the products their
teams need to focus upon and helps the sales managers to understand the likes and dislikes of their
customers more effectively.**

**In this challenge, you need to build an analyzer to analyze the historical sales data of an e-commerce 
organization, which is available as a CSV (Comma Separated Value) file in the src/main/resources folder 
and is called purchase_details.csv.**


The file contains the following information:
* date - contains the date of the purchase

* customer_id - contains the customer_id of the customer who has purchased the product

* product_category - contains the category_id of the product being sold

* payment_method - this can have only two values, credit for credit card payment and paypal for payments made through PayPal

* value - contains the sales amount in USD

* time_on_site - contains the amount of time a customer has spent on an e-commerce site

*   clicks_in_site - contains the number of clicks a user has made while accessing a site. 
                     This value is captured to see how many products a customer has visited 
                     before making a purchase decision

### Following are the key objectives for this challenge:

1.Read the CSV file that contains data of the sales record using Java classes.

2.Create a class to hold the sales record of individual products.

3.Display all the sales records.

You need to handle all exceptional situations that might occur while reading the file, parsing the values, etc.


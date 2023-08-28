Feature: Search and Place order for Products

Scenario: Search Experience for product search in both home and offers page

Given User is on GreenKart Landing page
When user searched with Shortname "Tom" and extracted actual name of product
Then user searched for "Tom" shortname in offers page 
And validate product name in offers page matches with Landing Page
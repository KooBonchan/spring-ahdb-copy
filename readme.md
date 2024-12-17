# Project stop: for 1 month.

# ArkhamDB Fan Project - minor copy

- scope: Revised Core set only

## Requirements

- Start date: 24.12.03
- max capability: Revised Core Set
- min capability: Just working with few dummy data

### Unsigned User

- read card info
- read deck list

### Signed User

- create deck
- my deck list
- reply to card
- reply to deck list

### Administrator

- add new card

## Diagram

![data definition](/assets/ddl.png)

- prototype, may get more complicated.

## Challenges before starting project

- ArkhamDB provides an API to access card data in JSON format. The card data itself contains nested groups of information, making a JSON-like data type appropriate for storage. I am attempting to translate this into a structured data model using MySQL, parsing the detailed information at the server layer. While this approach may reduce performance, it should be acceptable for such tiny project
- Try Tiles for view resolver: preserving header and footer theme.
- Try simple SpringSecurity
- Try unit test for all (persistence, business, presentation) layer.
- Business layer test actually handles persistence layer.
- Presentation layer test actually handles business and persistence layer. (Using MockMVC to disconnect from view)

CREATE TABLE country_phone_code (
	country_code varchar NOT NULL,
	country_name varchar NULL,
	CONSTRAINT country_phone_code_pkey PRIMARY KEY (country_code)
);

CREATE TABLE delivery_fee (
	id int4 NOT NULL,
	min_distance int4 NULL,
	max_distance int4 NULL,
	charge numeric NULL,
	CONSTRAINT delivery_fee_pkey PRIMARY KEY (id)
);

CREATE TABLE delivery_items (
	id int4 NOT NULL,
	item varchar NULL,
	CONSTRAINT delivery_items_pkey PRIMARY KEY (id)
);

CREATE TABLE delivery_order (
	order_id int4 NOT NULL,
	order_status_id int4 NULL,
	user_id int4 NULL,
	recepient_name varchar NULL,
	recepient_phone_number varchar NULL,
	pick_up_address varchar NULL,
	pick_up_province varchar NULL,
	pick_up_city varchar NULL,
	pick_up_district varchar NULL,
	pick_up_village varchar NULL,
	pick_up_latitude numeric NULL,
	pick_up_longitude numeric NULL,
	drop_off_address varchar NULL,
	drop_off_province varchar NULL,
	drop_off_city varchar NULL,
	drop_off_district varchar NULL,
	drop_off_village varchar NULL,
	drop_off_latitude numeric NULL,
	drop_off_longitude numeric NULL,
	notes varchar NULL,
	distance numeric NULL,
	delivery_fee_id int4 NULL,
	delivery_fee_total_charge int4 NULL,
	delivery_items_id int4 NULL,
	weight numeric NULL,
	CONSTRAINT order_pkey PRIMARY KEY (order_id)
);

CREATE TABLE users (
  id int4 PRIMARY KEY,
  full_name varchar,
  username varchar,
  country_phone_code varchar,
  phone_number varchar,
  created_at timestamp,
  country_code int
);


CREATE TABLE order_status (
	id int4 NOT NULL,
	status varchar NULL,
	CONSTRAINT order_status_pkey PRIMARY KEY (id)
);



CREATE TABLE payment (
	id int4 NOT NULL,
	order_id int4 NULL,
	payment_type varchar NULL,
	payment_date date NULL,
	payment_source varchar NULL,
	amount numeric NULL,
	CONSTRAINT payment_pkey PRIMARY KEY (id)
);

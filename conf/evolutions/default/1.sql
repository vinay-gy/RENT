# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cameras (
  id                        integer auto_increment not null,
  brand                     varchar(255),
  model                     varchar(255),
  age                       varchar(255),
  any_damages               tinyint(1) default 0,
  additional                tinyint(1) default 0,
  pick_up_drop              tinyint(1) default 0,
  any_accessories           tinyint(1) default 0,
  product_id                integer,
  description               varchar(500),
  constraint pk_cameras primary key (id))
;

create table categories (
  id                        integer auto_increment not null,
  category                  varchar(255),
  is_deleted                tinyint(1) default 0,
  is_active                 tinyint(1) default 0,
  constraint pk_categories primary key (id))
;

create table city (
  id                        integer auto_increment not null,
  state_id                  integer,
  city                      varchar(255),
  constraint pk_city primary key (id))
;

create table computers (
  id                        integer auto_increment not null,
  brand                     varchar(255),
  model                     varchar(255),
  product_id                integer,
  ram                       varchar(255),
  hard_disk                 varchar(255),
  processor                 varchar(255),
  any_damages               tinyint(1) default 0,
  damage_details            varchar(255),
  discription               varchar(1000),
  pic_and_drop              tinyint(1) default 0,
  accessories               tinyint(1) default 0,
  constraint pk_computers primary key (id))
;

create table customer (
  id                        integer auto_increment not null,
  customer_type_id          integer,
  login_id                  varchar(255),
  password                  varchar(255),
  name                      varchar(255),
  dob                       varchar(255),
  email                     varchar(255),
  mobile                    varchar(255),
  state                     varchar(255),
  city                      varchar(255),
  locality                  varchar(255),
  pincode                   varchar(255),
  address                   varchar(255),
  join_date                 datetime,
  is_active                 tinyint(1) default 0,
  is_deleted                tinyint(1) default 0,
  ratings                   varchar(255),
  constraint pk_customer primary key (id))
;

create table customer_type (
  id                        integer auto_increment not null,
  customer_type             varchar(255),
  is_deleted                tinyint(1) default 0,
  is_active                 tinyint(1) default 0,
  constraint pk_customer_type primary key (id))
;

create table locality (
  id                        integer auto_increment not null,
  city_id                   integer,
  locality                  varchar(255),
  constraint pk_locality primary key (id))
;

create table product (
  id                        integer auto_increment not null,
  title                     varchar(255),
  description               varchar(1000),
  product_type_id           integer,
  categories_id             integer,
  sub_categories_id         integer,
  customer_id               integer,
  email                     varchar(255),
  mobile                    varchar(255),
  address                   varchar(255),
  duration                  varchar(255),
  price                     decimal(12,2),
  deposit                   decimal(12,2),
  is_deposit_optional       tinyint(1) default 0,
  is_negotiable             tinyint(1) default 0,
  is_refundable             tinyint(1) default 0,
  posted_date               datetime,
  image_path                varchar(255),
  video_path                varchar(255),
  views                     varchar(255),
  likes                     varchar(255),
  is_active                 tinyint(1) default 0,
  is_available              tinyint(1) default 0,
  is_hidden                 tinyint(1) default 0,
  is_deleted                tinyint(1) default 0,
  search_key                varchar(255),
  constraint pk_product primary key (id))
;

create table product_type (
  id                        integer auto_increment not null,
  product_type              varchar(255),
  sub_category_id           integer,
  is_mapped                 tinyint(1) default 0,
  route                     varchar(255),
  is_active                 varchar(255),
  is_deleted                varchar(255),
  constraint pk_product_type primary key (id))
;

create table real_estate_commercial (
  id                        integer auto_increment not null,
  product_id                integer,
  description               varchar(1000),
  squre_feets               varchar(255),
  floor_no                  varchar(255),
  property_age              varchar(255),
  property_type             varchar(255),
  food_type                 varchar(255),
  toilet_type               varchar(255),
  is_furnished              varchar(255),
  is_parking_available      varchar(255),
  water_supply              varchar(255),
  balcony                   varchar(255),
  power_backup              varchar(255),
  security                  varchar(255),
  constraint pk_real_estate_commercial primary key (id))
;

create table real_estate_residential (
  id                        integer auto_increment not null,
  product_id                integer,
  description               varchar(1000),
  squre_feets               varchar(255),
  floor_no                  varchar(255),
  property_age              varchar(255),
  property_type             varchar(255),
  food_type                 varchar(255),
  toilet_type               varchar(255),
  is_furnished              varchar(255),
  is_parking_available      varchar(255),
  water_supply              varchar(255),
  balcony                   varchar(255),
  power_backup              varchar(255),
  security                  varchar(255),
  constraint pk_real_estate_residential primary key (id))
;

create table settings (
  settingsid                bigint auto_increment not null,
  KeyName                   varchar(256),
  Keyvalue                  varchar(500),
  Visible                   tinyint(1) default 0 not null,
  constraint pk_settings primary key (settingsid))
;

create table state (
  id                        integer auto_increment not null,
  state                     varchar(255),
  constraint pk_state primary key (id))
;

create table sub_categories (
  id                        integer auto_increment not null,
  sub_category              varchar(255),
  category_id               integer,
  is_deleted                tinyint(1) default 0,
  is_active                 tinyint(1) default 0,
  constraint pk_sub_categories primary key (id))
;

create table vehicles (
  id                        integer auto_increment not null,
  brand                     varchar(255),
  product_id                integer,
  description               varchar(1000),
  vehicle_type              varchar(255),
  year                      varchar(255),
  km_driven                 varchar(255),
  model                     varchar(255),
  is_with_driver            tinyint(1) default 0,
  safty_kit                 tinyint(1) default 0,
  rc_book                   tinyint(1) default 0,
  pick_and_drop             tinyint(1) default 0,
  helmet                    tinyint(1) default 0,
  constraint pk_vehicles primary key (id))
;

alter table cameras add constraint fk_cameras_product_1 foreign key (product_id) references product_type (id) on delete restrict on update restrict;
create index ix_cameras_product_1 on cameras (product_id);
alter table city add constraint fk_city_state_2 foreign key (state_id) references state (id) on delete restrict on update restrict;
create index ix_city_state_2 on city (state_id);
alter table computers add constraint fk_computers_product_3 foreign key (product_id) references product (id) on delete restrict on update restrict;
create index ix_computers_product_3 on computers (product_id);
alter table customer add constraint fk_customer_customerType_4 foreign key (customer_type_id) references customer_type (id) on delete restrict on update restrict;
create index ix_customer_customerType_4 on customer (customer_type_id);
alter table locality add constraint fk_locality_city_5 foreign key (city_id) references city (id) on delete restrict on update restrict;
create index ix_locality_city_5 on locality (city_id);
alter table product add constraint fk_product_productType_6 foreign key (product_type_id) references product_type (id) on delete restrict on update restrict;
create index ix_product_productType_6 on product (product_type_id);
alter table product add constraint fk_product_categories_7 foreign key (categories_id) references categories (id) on delete restrict on update restrict;
create index ix_product_categories_7 on product (categories_id);
alter table product add constraint fk_product_subCategories_8 foreign key (sub_categories_id) references sub_categories (id) on delete restrict on update restrict;
create index ix_product_subCategories_8 on product (sub_categories_id);
alter table product add constraint fk_product_customer_9 foreign key (customer_id) references customer (id) on delete restrict on update restrict;
create index ix_product_customer_9 on product (customer_id);
alter table product_type add constraint fk_product_type_subCategory_10 foreign key (sub_category_id) references sub_categories (id) on delete restrict on update restrict;
create index ix_product_type_subCategory_10 on product_type (sub_category_id);
alter table real_estate_commercial add constraint fk_real_estate_commercial_product_11 foreign key (product_id) references product (id) on delete restrict on update restrict;
create index ix_real_estate_commercial_product_11 on real_estate_commercial (product_id);
alter table real_estate_residential add constraint fk_real_estate_residential_product_12 foreign key (product_id) references product (id) on delete restrict on update restrict;
create index ix_real_estate_residential_product_12 on real_estate_residential (product_id);
alter table sub_categories add constraint fk_sub_categories_category_13 foreign key (category_id) references categories (id) on delete restrict on update restrict;
create index ix_sub_categories_category_13 on sub_categories (category_id);
alter table vehicles add constraint fk_vehicles_product_14 foreign key (product_id) references product (id) on delete restrict on update restrict;
create index ix_vehicles_product_14 on vehicles (product_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table cameras;

drop table categories;

drop table city;

drop table computers;

drop table customer;

drop table customer_type;

drop table locality;

drop table product;

drop table product_type;

drop table real_estate_commercial;

drop table real_estate_residential;

drop table settings;

drop table state;

drop table sub_categories;

drop table vehicles;

SET FOREIGN_KEY_CHECKS=1;


#
# drop table if exists PEI_USER;
# drop table if exists PEI_USER_ADDRESS;
# drop table if exists pei_cookbook;
# drop table if exists pei_cook_material;
# 用户基本表
CREATE TABLE PEI_USER(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  LOGIN_NAME    VARCHAR(64) NOT NULL UNIQUE   COMMENT '登录账号',
  EMAIL         VARCHAR(64)                   COMMENT '电子邮箱',
  SEX           TINYINT(1) DEFAULT '0'        COMMENT '性别,0:保密,1:男,2:女',
  PASSWORD      VARCHAR(255) NOT NULL         COMMENT '密码',
  SALT          VARCHAR(64) NOT NULL,
  CREATED_AT    DATETIME                      COMMENT '创建时间',
  UPDATED_AT    DATETIME                      COMMENT '更新时间',
  NICK_NAME     VARCHAR(64)                   COMMENT '用户昵称',
  LAST_LOGIN_TIME DATETIME                    COMMENT '用户上次登录时间',
  LAST_LOGIN_IP VARCHAR(255)                  COMMENT '用户上次登录IP地址',
  ROLES         VARCHAR(255)                  COMMENT '用户所属角色',
  BIRTHDAY      DATE                          COMMENT '出生日期'
) ENGINE=INNODB comment='用户基本信息表';

# 用户收货信息表
CREATE TABLE PEI_USER_ADDRESS(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  ADDRESS_NAME      VARCHAR(255)              COMMENT '收获信息名称',
  USER_ID           BIGINT                    COMMENT '用户ID,取值表PEI_USER',
  CONSIGNEE         VARCHAR(64)               COMMENT '收货人名称',
  COUNTRY           smallint(5)               COMMENT '收货人的国家',
  PROVINCE          smallint(5)               COMMENT '收货人的省份',
  CITY              smallint(5)               COMMENT '收货人城市',
  DISTRICT          smallint(5)               COMMENT '收货人地区',
  ADDRESS           varchar(255)              COMMENT '收货人详细地址',
  ZIPCODE           varchar(10)               COMMENT '收货人的邮编',
  TEL               varchar(20)               COMMENT '收货人的固定电话号码',
  MOBILE            varchar(15)               COMMENT '收货人的手机号码',
  IS_DEFAULT        tinyint(1)                comment '是否作为默认收货地址,0,否;1,是',
  created_at        datetime                  comment '创建日期',
  updated_at        datetime                  comment '更新日期'
) ENGINE=INNODB;

# 食谱信息表
create table pei_cookbook(
  ID bigint auto_increment primary key not null ,
  name              varchar(64)               comment '食谱名称',
  intro             text                      comment '食谱介绍',
  intro_thumb       varchar(255)              comment '食谱展示缩略图片',
  intro_img         varchar(255)              comment '食谱展示大图片',
  cookery_book      text                      comment '烹饪说明',
  created_at        DATETIME                  comment '创建时间',
  updated_at        DATETIME                  comment '更新时间'

) engine=innodb comment='食谱信息表';

# 食材及调味品信息表
create table pei_cook_material(
  ID bigint auto_increment primary key not null ,
  name              varchar(64)               comment '食材名称',
  intro             text                      comment '食材的简单介绍',
  intro_thumb       varchar(255)              comment '食材展示缩略图片',
  intro_img         varchar(255)              comment '食材展示图片',
  material_number   decimal(10,2)             comment '库存数量',
  warn_number       int(10)                   comment '库存报警数量,用于提示采购',
  material_unit     varchar(10)               comment '食材计量单位',
  market_price      decimal(10,2)             comment '市场定价',
  created_at        datetime                  comment '添加时间',
  updated_at        datetime                  comment '更新时间',
  brand_id          bigint                    comment '品牌ID'
) engine=innodb comment='食材及调味品信息表';

# 食谱与食材关联表
create table pri_cook_material_rela(
  ID bigint auto_increment primary key not null ,
  cookbook_id bigint                          comment '食谱ID',
  material_id bigint                          comment '食材ID'
) engine=innodb comment='食谱与食材关联表';

# 品牌信息表
create table pei_brand(
  ID bigint auto_increment primary key not null ,
  name              varchar(255)              comment '品牌名称',
  brand_logo        varchar(255)              comment '品牌公司logo',
  brand_desc        text                      comment '品牌介绍',
  brand_site        varchar(255)              comment '品牌网站',
  created_at        datetime                  comment '添加时间',
  updated_at        datetime                  comment '更新时间'
) engine=innodb comment='品牌信息表';

# 订单表
create table pei_order(
  ID bigint auto_increment primary key not null ,
  order_sn          varchar(20)               comment '订单流水号,唯一',
  user_id           bigint                    comment '用户ID',
  order_status      tinyint(1)                comment '订单状态,0,未确认;1,已确认;2,已取消;3,无效;4,退货;5,完成',
  shipping_status   tinyint(1)                comment '配送状态,0,配菜中;1,已发货;2,配送完成',
  pay_status        tinyint(1)                comment '支付状态,0，未付款;1，付款中;2，已付款',
  order_amount      decimal(10,2)             comment '订单总金额',
  shipping_fee      decimal(10,2)             comment '配送费用',
  pay_fee           decimal(10,2)             comment '支付费用',
  user_address_id   bigint                    comment '用户收货信息ID',
  created_at        datetime                  comment '订单创建日期',
  confirmed_at      datetime                  comment '订单确认时间',
  shipped_at        datetime                  comment '订单配送时间',
  payed_at          datetime                  comment '订单支付时间',
  finished_at       datetime                  comment '订单完成时间',
  remark            text                      comment '订单付款备注,用户在提交订单时填写'
) engine=innodb comment='订单信息表';

# 地区信息表
create table pei_ragion(
  ID bigint auto_increment primary key not null ,
  name              varchar(64)               comment '地区名称',
  parent_id         bigint                    comment '上级地区ID'
) engine=innodb comment='地区信息表';

commit;
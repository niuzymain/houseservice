create table tb_reserve(
reserve_id int(100) not null auto_increment primary key,
reserve_time datetime not null,
reserve_addr varchar(1000) not null,
reserve_des varchar(1000) default null,
user_id int(100) not null,
servicer_id int(100) not null,
foreign key(user_id) references tb_user(user_id),
foreign key(servicer_id) references tb_servicer(servicer_id)
)

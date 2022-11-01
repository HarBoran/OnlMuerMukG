CREATE TABLE restaurant(
 restaurant_id INT AUTO_INCREMENT PRIMARY KEY, 
 restaurant_name VARCHAR(100), 
 owner_id VARCHAR(100), 
 latitude DECIMAL(16,14), 
 hardness DECIMAL(17,14), 
 restaurant_category VARCHAR(100), 
 signature_food VARCHAR(100)
 );
INSERT INTO restaurant (restaurant_name, restaurant_category, signature_food, owner_id, latitude, hardness) 
VALUES('계림', '한식', '닭볶음탕', 'NULL', 37.57017640061196, 126.99250108814104), 
       ('남원추어탕', '한식', '추어탕', 'NULL', 37.57017640060342, 126.99142157107046), 
       ('종로설렁탕', '한식', '설렁탕', 'NULL', 37.570332763474184, 126.98990211169911), 
       ('대륙', '중식', '짜장면', 'NULL', 37.570332763474184, 126.98990211169911), 
       ('라밥 종로점', '기타', '떡볶이', 'NULL', 37.57040759210365, 126.98978377874494), 
       ('호호식당 익선', '일식', '우나기동', 'NULL', 37.57302650000156, 126.98637672253678), 
       ('경영카츠 익선점', '일식', '돈가스', 'NULL', 37.57302650000156, 126.98637672253678), 
       ('종로찌개마을', '한식', '대구탕', 'NULL', 37.57302650000156, 126.98637672253678), 
       ('익선디미방', '양식', '파스타', 'NULL', 37.57302650000156, 126.98637672253678);
CREATE TABLE restaurant_menu(
 restaurant_id INT, 
 menu_id INT, 
 FOREIGN KEY(restaurant_id) REFERENCES restaurant(restaurant_id), 
 FOREIGN KEY(menu_id) REFERENCES menu(menu_id)
    );
CREATE TABLE menu(
 menu_id INT AUTO_INCREMENT PRIMARY KEY, 
 food_name VARCHAR(100), 
 food_category VARCHAR(100)
 );
INSERT INTO menu (food_name, food_category) 
 VALUES('닭볶음탕', '국/탕');
CREATE TABLE user(
 user_id INT AUTO_INCREMENT PRIMARY KEY, 
 login_id VARCHAR(100) NOT NULL UNIQUE, 
 latitude_user DECIMAL(16,14), 
 hardness_user DECIMAL(17,14)
 );
INSERT INTO user (login_id, latitude_user, hardness_user) 
 VALUES('yyyyoooo', 37.57098723159448, 126.9918994976269);
CREATE TABLE user_rap(
 user_id INT, 
 restaurant_id INT, 
 eat_date DATE, 
 eat_time TIME, 
 grade DECIMAL(2,1), 
 FOREIGN KEY(user_id) REFERENCES user(user_id), 
 FOREIGN KEY(restaurant_id) REFERENCES restaurant(restaurant_id)
 );
INSERT INTO user_rap (eat_date, eat_time, grade) 
 VALUES('2022-11-01', '12:30:00', 5.0);
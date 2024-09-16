CREATE TABLE chat_sessions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(255),
    session_date DATE,
    chat_history TEXT
);


CREATE TABLE USER(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name varchar(255),
    password varchar(255),
    create_time timestamp default current_timestamp
);
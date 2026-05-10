CREATE DATABASE IF NOT EXISTS finalproject;

USE finalproject;

DROP TABLE IF EXISTS cats;

CREATE TABLE cats (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      breed VARCHAR(64) NOT NULL,
                      color_pattern VARCHAR(64),
                      eye_color VARCHAR(32),
                      fur_length VARCHAR(32),
                      personality_type VARCHAR(64),
                      created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

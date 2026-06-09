-- 카테고리 초기 데이터 (프론트 ID 1~13 매핑과 일치)
-- MySQL 영구 DB 환경: 기동 시마다 실행되므로 INSERT IGNORE로 멱등 처리 (이미 있으면 무시)
INSERT IGNORE INTO category (category_id, category_name) VALUES (1, '스포츠');
INSERT IGNORE INTO category (category_id, category_name) VALUES (2, '언어');
INSERT IGNORE INTO category (category_id, category_name) VALUES (3, '악기');
INSERT IGNORE INTO category (category_id, category_name) VALUES (4, '댄스');
INSERT IGNORE INTO category (category_id, category_name) VALUES (5, '반려동물');
INSERT IGNORE INTO category (category_id, category_name) VALUES (6, '사교');
INSERT IGNORE INTO category (category_id, category_name) VALUES (7, '요리/레시피');
INSERT IGNORE INTO category (category_id, category_name) VALUES (8, '게임/오락');
INSERT IGNORE INTO category (category_id, category_name) VALUES (9, '사진/영상');
INSERT IGNORE INTO category (category_id, category_name) VALUES (10, '독서');
INSERT IGNORE INTO category (category_id, category_name) VALUES (11, '노래');
INSERT IGNORE INTO category (category_id, category_name) VALUES (12, '자동차');
INSERT IGNORE INTO category (category_id, category_name) VALUES (13, '여행');

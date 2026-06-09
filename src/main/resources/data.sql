-- 카테고리 초기 데이터 (프론트 ID 1~13 매핑과 일치해야 함)
-- 인메모리 H2 + ddl-auto:create + sql.init.mode:always 환경에서 기동 시마다 시드됨
INSERT INTO category (category_id, category_name) VALUES (1, '스포츠');
INSERT INTO category (category_id, category_name) VALUES (2, '언어');
INSERT INTO category (category_id, category_name) VALUES (3, '악기');
INSERT INTO category (category_id, category_name) VALUES (4, '댄스');
INSERT INTO category (category_id, category_name) VALUES (5, '반려동물');
INSERT INTO category (category_id, category_name) VALUES (6, '사교');
INSERT INTO category (category_id, category_name) VALUES (7, '요리/레시피');
INSERT INTO category (category_id, category_name) VALUES (8, '게임/오락');
INSERT INTO category (category_id, category_name) VALUES (9, '사진/영상');
INSERT INTO category (category_id, category_name) VALUES (10, '독서');
INSERT INTO category (category_id, category_name) VALUES (11, '노래');
INSERT INTO category (category_id, category_name) VALUES (12, '자동차');
INSERT INTO category (category_id, category_name) VALUES (13, '여행');

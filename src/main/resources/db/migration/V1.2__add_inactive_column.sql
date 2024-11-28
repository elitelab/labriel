ALTER TABLE users ADD COLUMN inactive_last_check TEXT;
UPDATE users SET inactive_last_check = DATETIME('now');
CREATE TABLE IF NOT EXISTS users (
                                     id INTEGER PRIMARY KEY AUTOINCREMENT,
                                     date TEXT NOT NULL,
                                     discord_id TEXT NOT NULL,
                                     activity_score INTEGER NOT NULL,
                                     last_message_date TEXT
);
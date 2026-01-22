CREATE TABLE inventory.products (
    id UUID PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    price BIGINT NOT NULL CHECK (price >= 0),
    stock_quantity INTEGER NOT NULL CHECK (stock_quantity >= 0),
    fried_frozen BOOLEAN DEFAULT FALSE,
    expiration_date DATE
);

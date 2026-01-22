CREATE TABLE ordering.orders (
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    status VARCHAR(255) NOT NULL,
    full_price BIGINT NOT NULL,
    address_snapshot JSONB NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ordering.order_items (
    id UUID PRIMARY KEY,
    order_id UUID REFERENCES ordering.orders(id) NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    unit_price BIGINT NOT NULL,
    quantity INT NOT NULL
);

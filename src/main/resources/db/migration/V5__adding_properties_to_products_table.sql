ALTER TABLE inventory.products 
ADD COLUMN grams INTEGER NOT NULL CHECK ( grams >= 0 ),
ADD COLUMN package_quantity INTEGER NOT NULL CHECK ( package_quantity >= 0 );

CREATE TABLE `m_product_category` (
    `id` varchar(255) NOT NULL,
    `name` varchar(255) DEFAULT NULL,
    `created_at` datetime NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_category` (`name`)
);

CREATE INDEX `category_name` ON `m_product_category` (`name`);

CREATE TABLE `m_product` (
    `id` varchar(255) NOT NULL,
    `name` varchar(255) DEFAULT NULL,
    `price` decimal(19,2) DEFAULT NULL,
    `sku` varchar(255) DEFAULT NULL,
    `stock` bigint DEFAULT NULL,
    `category_id` varchar(255) DEFAULT NULL,
    `created_at` datetime NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_product` (`sku`),
    KEY `FK_category_id` (`category_id`),
    CONSTRAINT `FK_category_id` FOREIGN KEY (`category_id`) REFERENCES `m_product_category` (`id`)
);

CREATE INDEX `product_name` ON `m_product` (`sku`);

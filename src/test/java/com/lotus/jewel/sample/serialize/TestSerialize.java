package com.lotus.jewel.sample.serialize;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.time.LocalDateTime;

//import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class TestSerialize {

    @Test
    @DisplayName("테스트이름")
    public static void testSerializationUtils() {
        /* given */
        Order order = Order.builder()
                .id(1L)
                .name("huisam")
                .address("Seoul")
                .product("사과")
                .price(123)
                .orderedTime(LocalDateTime.now())
                .build();
        Order afterOrder = Order.builder().build();

        /* when */
        // serailize
        final byte[] byteArray = SerializationUtils.serialize(order);
        // deserialize
        afterOrder = SerializationUtils.deserialize(byteArray);

        /* then */
        assertThat(afterOrder).isEqualTo(order);
    }

    public static class Order implements Serializable {

        private static final long serialVersionUID = -6873597541204880676L;

        private Long id;

        private String name;

        private String address;

        private String product;

        private Integer price;

        private LocalDateTime orderedTime;

        private Order(Builder builder) {
            id = builder.id;
            name = builder.name;
            address = builder.address;
            product = builder.product;
            price = builder.price;
            orderedTime = builder.orderedTime;
        }

        public static Builder builder(){
            return new Builder();
        }

        public static final class Builder {
            private Long id;
            private String name;
            private String address;
            private String product;
            private Integer price;
            private LocalDateTime orderedTime;

            private Builder() {
                super();
            }

            public Builder id(Long val) {
                id = val;
                return this;
            }

            public Builder name(String val) {
                name = val;
                return this;
            }

            public Builder address(String val) {
                address = val;
                return this;
            }

            public Builder product(String val) {
                product = val;
                return this;
            }

            public Builder price(Integer val) {
                price = val;
                return this;
            }

            public Builder orderedTime(LocalDateTime val) {
                orderedTime = val;
                return this;
            }

            public Order build() {
                return new Order(this);
            }
        }
    }
}

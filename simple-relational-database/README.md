mvn liquibase:rollback -Dliquibase.rollbackTag=14001-07-02-15:38



docker run -d --name=prometheus -p 9090:9090 -v D:\projects\mostafa-springboot-github\Springboot-Samples\simple-relational-database\src\main\resources\prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus --config.file=/etc/prometheus/prometheus.yml  
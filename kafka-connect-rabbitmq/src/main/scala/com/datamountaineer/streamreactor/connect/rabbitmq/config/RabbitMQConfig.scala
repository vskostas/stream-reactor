package com.datamountaineer.streamreactor.connect.rabbitmq.config

import com.datamountaineer.streamreactor.connect.config.base.traits._
import org.apache.kafka.common.config.ConfigDef
import org.apache.kafka.common.config.ConfigDef.{Importance, Type}
import java.util

object RabbitMQConfig {
  val config: ConfigDef = new ConfigDef()
      //Required
      .define(RabbitMQConfigConstants.HOST_CONFIG,Type.STRING,Importance.HIGH,RabbitMQConfigConstants.HOST_DOC,
        RabbitMQConfigConstants.ConfigGroups.CONNECTION,1,ConfigDef.Width.MEDIUM,RabbitMQConfigConstants.HOST_DISPLAY)
      .define(RabbitMQConfigConstants.KCQL_CONFIG,Type.STRING,Importance.HIGH,RabbitMQConfigConstants.KCQL_DOC,
        RabbitMQConfigConstants.ConfigGroups.KCQL,2,ConfigDef.Width.MEDIUM,RabbitMQConfigConstants.KCQL_DISPLAY)
      //Optional
      .define(RabbitMQConfigConstants.USER_CONFIG,Type.STRING,RabbitMQConfigConstants.USER_DEFAULT,Importance.HIGH,
          RabbitMQConfigConstants.USER_DOC,RabbitMQConfigConstants.ConfigGroups.CONNECTION,3,ConfigDef.Width.MEDIUM,RabbitMQConfigConstants.USER_DISPLAY)
      .define(RabbitMQConfigConstants.PASSWORD_CONFIG,Type.PASSWORD,RabbitMQConfigConstants.PASSWORD_DEFAULT,Importance.HIGH,
          RabbitMQConfigConstants.PASSWORD_DOC,RabbitMQConfigConstants.ConfigGroups.CONNECTION,4,ConfigDef.Width.MEDIUM,RabbitMQConfigConstants.PASSWORD_DISPLAY)
      .define(RabbitMQConfigConstants.PORT_CONFIG,Type.INT,RabbitMQConfigConstants.PORT_DEFAULT,Importance.MEDIUM,
          RabbitMQConfigConstants.PORT_DOC,RabbitMQConfigConstants.ConfigGroups.CONNECTION,5,ConfigDef.Width.MEDIUM,RabbitMQConfigConstants.PORT_DISPLAY)
      .define(RabbitMQConfigConstants.VIRTUAL_HOST_CONFIG,Type.STRING,RabbitMQConfigConstants.VIRTUAL_HOST_DEFAULT,Importance.LOW,
          RabbitMQConfigConstants.VIRTUAL_HOST_DOC,RabbitMQConfigConstants.ConfigGroups.CONNECTION,6,ConfigDef.Width.MEDIUM,RabbitMQConfigConstants.VIRTUAL_HOST_DISPLAY)
      .define(RabbitMQConfigConstants.POLLING_TIMEOUT_CONFIG,Type.LONG,RabbitMQConfigConstants.POLLING_TIMEOUT_DEFAULT, Importance.MEDIUM,
          RabbitMQConfigConstants.POLLING_TIMEOUT_DOC, RabbitMQConfigConstants.ConfigGroups.CONNECTION, 7, ConfigDef.Width.MEDIUM,RabbitMQConfigConstants.POLLING_TIMEOUT_CONFIG)
      //Converters
      .define(RabbitMQConfigConstants.DEFAULT_CONVERTER_CONFIG, Type.STRING, RabbitMQConfigConstants.DEFAULT_CONVERTER_DEFAULT, Importance.HIGH,
          RabbitMQConfigConstants.DEFAULT_CONVERTER_DOC, RabbitMQConfigConstants.ConfigGroups.CONVERTERS, 8, ConfigDef.Width.MEDIUM, RabbitMQConfigConstants.DEFAULT_CONVERTER_DISPLAY)
}

case class RabbitMQConfig(props: util.Map[String, String])
    extends BaseConfig(RabbitMQConfigConstants.CONNECTOR_PREFIX, RabbitMQConfig.config, props)
        with KcqlSettings
        with UserSettings
        with ConnectionSettings
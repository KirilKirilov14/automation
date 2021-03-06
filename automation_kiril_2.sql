PGDMP         7                z        
   automation    14.2    14.2     I           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            J           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            K           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            L           1262    16394 
   automation    DATABASE     n   CREATE DATABASE automation WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE automation;
                postgres    false            B          0    16463    automation_rules 
   TABLE DATA           ?   COPY public.automation_rules (automation_rule_id, sensor_id, sensor_max_value_trigger, min_trigger_endpoint, sensor_min_value_trigger, max_trigger_endpoint, automation_rule_active) FROM stdin;
    public          postgres    false    220   ?       7          0    16395    devices 
   TABLE DATA           k   COPY public.devices (device_id, device_name, device_location, device_type, end_point, user_id) FROM stdin;
    public          postgres    false    209   T       9          0    16401    logs 
   TABLE DATA           U   COPY public.logs (log_id, log_date, log_description, log_level, user_id) FROM stdin;
    public          postgres    false    211   ?       C          0    16477    roles 
   TABLE DATA           8   COPY public.roles (role_id, role_authority) FROM stdin;
    public          postgres    false    221          F          0    16734    sensor_data 
   TABLE DATA           N   COPY public.sensor_data (sensor_data_id, sensor_id, sensor_value) FROM stdin;
    public          postgres    false    224   B       ;          0    16407    sensors 
   TABLE DATA           G   COPY public.sensors (sensor_id, device_id, sensor_type_id) FROM stdin;
    public          postgres    false    213   _       =          0    16411    sensors_types 
   TABLE DATA           V   COPY public.sensors_types (sensor_type_id, sensor_type, sensor_data_type) FROM stdin;
    public          postgres    false    215   ?       ?          0    16417    users 
   TABLE DATA           ?   COPY public.users (user_id, user_name, user_password, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled) FROM stdin;
    public          postgres    false    217   ?       D          0    16484    users_authorities 
   TABLE DATA           O   COPY public.users_authorities (users_user_id, authorities_role_id) FROM stdin;
    public          postgres    false    222   q       T           0    0 '   automation_rules_automation_rule_id_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public.automation_rules_automation_rule_id_seq', 6, true);
          public          postgres    false    219            U           0    0    devices_device_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.devices_device_id_seq', 1, false);
          public          postgres    false    210            V           0    0    logs_log_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.logs_log_id_seq', 2, true);
          public          postgres    false    212            W           0    0    sensor_data_sensor_data_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.sensor_data_sensor_data_id_seq', 1, false);
          public          postgres    false    223            X           0    0    sensors_sensor_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.sensors_sensor_id_seq', 1, false);
          public          postgres    false    214            Y           0    0     sensors_types_sensor_type_id_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.sensors_types_sensor_type_id_seq', 1, false);
          public          postgres    false    216            Z           0    0    users_user_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.users_user_id_seq', 1, false);
          public          postgres    false    218            B   T   x?3?4??0??())???7?4?34??3?340?OεO??K??/O-R52???44%RiZg?1?!??9ц?ox	W? ?#2h      7   X   x?3?LI-?LN???,I?H??tJM)????t.-.??U??*?*?f?erf??X??Z??Y?????$???$rr??qqq ?>?      9   J   x?3?4204?50?54S00?#????DΜԲ?NC.#d%??VFV?Ɯ?))?)
y??
9??
?F@?1z\\\ ???      C      x?3?tt????2?v?????? +??      F      x?????? ? ?      ;      x?3?4?4?2?F\1z\\\ 	      =   .   x?3??(??L?,??L?/M?I?2?I?-H-J,)-J?	??qqq M?      ?   ?   x?=̻?0???}flO/?/Q ????5?j*H???511??????#??i/2g,?????3?????uZt]?sp? ??a?F)?&?/?I???@^h?t??	?	???4?>?xѨ??&??ς??qU?????yj??b???b??zH)???0d      D      x?3?4?2?4?????? ??     
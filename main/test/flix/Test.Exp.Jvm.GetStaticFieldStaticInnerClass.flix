namespace Test/Exp/Jvm/GetStaticFieldStaticInnerClass {

    @test
    def testGetStaticBoolField01(): Bool \ IO =
        import static get dev.flix.test.TestClass$_StaticNestedClass.BOOL_FIELD: Bool \ IO as getField;
        getField() == true

    @test
    def testGetStaticCharField01(): Bool \ IO =
        import static get dev.flix.test.TestClass$_StaticNestedClass.CHAR_FIELD: Char \ IO as getField;
        getField() == 'A'

    @test
    def testGetStaticFloat32Field01(): Bool \ IO =
        import static get dev.flix.test.TestClass$_StaticNestedClass.FLOAT32_FIELD: Float32 \ IO as getField;
        getField() == 123.456f32

    @test
    def testGetStaticFloat64Field01(): Bool \ IO =
        import static get dev.flix.test.TestClass$_StaticNestedClass.FLOAT64_FIELD: Float64 \ IO as getField;
        getField() == 123.456f64

    @test
    def testGetStaticInt8Field01(): Bool \ IO =
        import static get dev.flix.test.TestClass$_StaticNestedClass.INT8_FIELD: Int8 \ IO as getField;
        getField() == 127i8

    @test
    def testGetStaticInt16Field01(): Bool \ IO =
        import static get dev.flix.test.TestClass$_StaticNestedClass.INT16_FIELD: Int16 \ IO as getField;
        getField() == 127i16

    @test
    def testGetStaticInt32Field01(): Bool \ IO =
        import static get dev.flix.test.TestClass$_StaticNestedClass.INT32_FIELD: Int32 \ IO as getField;
        getField() == 127i32

    @test
    def testGetStaticInt64Field01(): Bool \ IO =
        import static get dev.flix.test.TestClass$_StaticNestedClass.INT64_FIELD: Int64 \ IO as getField;
        getField() == 127i64

    @test
    def testGetStaticStringField01(): Bool \ IO =
        import static get dev.flix.test.TestClass$_StaticNestedClass.STRING_FIELD: String \ IO as getField;
        getField() == "Hello World"

    @test
    def testGetStaticPureField01(): Bool =
        import static get dev.flix.test.TestClass$_StaticNestedClass.STRING_FIELD: String \ {} as getField;
        getField() == "Hello World"

    @test
    def testGetStaticObjectField01(): ##java.lang.Object \ IO =
        import static get dev.flix.test.TestClass$_StaticNestedClass.STRING_FIELD: ##java.lang.Object \ IO as getField;
        getField()
}

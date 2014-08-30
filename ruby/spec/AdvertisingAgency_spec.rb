require_relative '../app/AdvertisingAgency'

describe AdvertisingAgency do
  after(:each) do
    results = AdvertisingAgency.numberOfRejections(@requests)
    expect(results).to eq(@expected)
  end

  it "test 1" do
    @requests = [1, 2, 3]
    @expected = 0
  end

  it "test 2" do
    @requests = [1, 1, 1]
    @expected = 2
  end

  it "test 3" do
    @requests = [1, 2, 1, 2]
    @expected = 2
  end

  it "test 4" do
    @requests = [24, 51, 23, 96, 51, 73, 30, 42, 44, 20, 20, 20, 58, 23, 44, 35, 2, 42, 20, 74, 24, 37, 68, 95, 34, 37, 42, 37, 95, 68, 57, 20, 95, 24, 24, 20, 20, 10, 44, 30, 47, 42, 72, 57, 10, 47, 30, 68, 96]
    @expected = 28
  end

  it "test 5" do
    @requests = [100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100]
    @expected = 49
  end
end

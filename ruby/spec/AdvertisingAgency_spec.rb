require_relative "../app/%s" % [File.basename(__FILE__, "_spec.rb")]

path = __FILE__.sub(/\.rb$/, ".json")
$DATA = JSON.parse(File.read(path))

describe AdvertisingAgency do
  after(:each) do
    results = AdvertisingAgency.numberOfRejections(@requests)
    expect(results).to eq(@expected)
  end

  $DATA.each_with_index do |t, i|
    it "test #{i}" do
      @requests = t[0]
      @expected = t[1]
    end
  end
end

name = File.basename(__FILE__, "_spec.rb")
require_relative "../app/%s" % [name]

path = __FILE__.sub(/\.rb$/, ".json")
$DATA = JSON.parse(File.read(path))

describe name do
  after(:each) do
    results = Object.const_get(name).earnings(@timeA, @priceA, @timeB, @priceB)

    if @expected == 0
      expect(results).to eq(0)
    else
      p = (results - @expected).abs / @expected
      expect(p).to be < 0.01
    end
  end

  $DATA.each_with_index do |t, i|
    it "test #{i}" do
      @timeA    = t[0]
      @priceA   = t[1]
      @timeB    = t[2]
      @priceB   = t[3]
      @expected = t[4]
    end
  end
end

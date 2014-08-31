name = File.basename(__FILE__, "_spec.rb")
require_relative "../app/%s" % [name]

path = __FILE__.sub(/\.rb$/, ".json")
$DATA = JSON.parse(File.read(path))

describe name do
  after(:each) do
    results = Object.const_get(name).evaluate(@drawing, @picks)
    expect(results).to eq(@expected)
  end

  $DATA.each_with_index do |t, i|
    it "test #{i}" do
      @drawing  = t[0]
      @picks    = t[1]
      @expected = t[2]
    end
  end
end

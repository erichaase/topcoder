name = File.basename(__FILE__, "_spec.rb")
require_relative "../app/%s" % [name]

path = __FILE__.sub(/\.rb$/, ".json")
$DATA = JSON.parse(File.read(path))

describe name do
  after(:each) do
    results = Object.const_get(name).getEnds(@tasks)
    expect(results).to eq(@expected)
  end

  $DATA.each_with_index do |t, i|
    it "test #{i}" do
      @tasks    = t[0]
      @expected = t[1]
    end
  end
end
